package com.pi.gestaocompras.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pi.gestaocompras.entities.Cidade;
import com.pi.gestaocompras.entities.CotacaoCompra;
import com.pi.gestaocompras.entities.CotacaoCompraItem;
import com.pi.gestaocompras.entities.Estado;
import com.pi.gestaocompras.entities.Fornecedor;
import com.pi.gestaocompras.entities.Funcionario;
import com.pi.gestaocompras.entities.Gerente;
import com.pi.gestaocompras.entities.NotaFiscal;
import com.pi.gestaocompras.entities.NotaFiscalItem;
import com.pi.gestaocompras.entities.OrdemCompra;
import com.pi.gestaocompras.entities.OrdemCompraItem;
import com.pi.gestaocompras.entities.Produto;
import com.pi.gestaocompras.repositories.CidadeRepository;
import com.pi.gestaocompras.repositories.CotacaoCompraItemRepository;
import com.pi.gestaocompras.repositories.CotacaoCompraRepository;
import com.pi.gestaocompras.repositories.EstadoRepository;
import com.pi.gestaocompras.repositories.FornecedorRepository;
import com.pi.gestaocompras.repositories.FuncionarioRepository;
import com.pi.gestaocompras.repositories.GerenteRepository;
import com.pi.gestaocompras.repositories.NotaFiscalItemRepository;
import com.pi.gestaocompras.repositories.NotaFiscalRepository;
import com.pi.gestaocompras.repositories.OrdemCompraItemRepository;
import com.pi.gestaocompras.repositories.OrdemCompraRepository;
import com.pi.gestaocompras.repositories.ProdutoRepository;

@Configuration
@Profile ("test")
public class TestConfig implements  CommandLineRunner{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
    @Autowired 
    private ProdutoRepository produtorepository;
    @Autowired
    private FornecedorRepository fornecedorrepository;
    @Autowired
    private CidadeRepository cidaderepository;
    @Autowired
    private EstadoRepository estadorepository;
    @Autowired
    private FuncionarioRepository funcionariorepository;
    @Autowired
    private NotaFiscalRepository nfrepository;
    @Autowired
    private NotaFiscalItemRepository nfitemrepository;
    @Autowired
    private OrdemCompraRepository ocrepository;
    @Autowired
    private OrdemCompraItemRepository ocitemrepository;
    @Autowired
    private GerenteRepository gerenterepository;
    @Autowired
    private CotacaoCompraRepository cotacomrepository;
    @Autowired
    private CotacaoCompraItemRepository cotaitensrepository;
    
    @Override
	public void run(String... args) throws Exception {
        Produto p = new Produto();
        p.setNome("Carro");
        p.setDescrição("descrição");
        p.setQuantidademin(5);
        p.setEstoque(4);
        Produto p2 = new Produto();
        p2.setNome("Moto");
        p2.setDescrição("descrição da moto");
        p2.setQuantidademin(3);
        p2.setEstoque(3);
        produtorepository.saveAll(Arrays.asList(p,p2));
        Fornecedor f = new Fornecedor();
        Fornecedor f2 = new Fornecedor();
        Fornecedor f3 = new Fornecedor();
        f.setCnpj("41562");
        f.setNome("Ponto Frio");
        f.setLogin("ponto123");
        f.setSenha("frio123");
        f.setEmail("pontofrio@gmail.com");
        f2.setCnpj("4124122");
        f2.setNome("Casas Bahia");
        f2.setLogin("casas123");
        f2.setSenha("bahia123");
        f2.setEmail("casasbahia@gmail.com");
        f3.setCnpj("4412432r42");
        f3.setNome("Americanas");
        f3.setLogin("americanas123");
        f3.setSenha("todomundovai");
        f3.setEmail("americanas@gmail.com");
        Cidade c = new Cidade();
        Cidade c2 = new Cidade();
        c.setNome("Araucária");
        c2.setNome("Maringa");
        Estado e = new Estado();
        e.setNome("Paraná");
        f.setCidade(c);
        f2.setCidade(c);
        f3.setCidade(c2);
        c.getFornecedores().add(f);
        c.getFornecedores().add(f2);
        c2.getFornecedores().add(f3);
        estadorepository.save(e);
        c.setEstado(e);
        c2.setEstado(e);
        cidaderepository.saveAll(Arrays.asList(c,c2));
        fornecedorrepository.saveAll(Arrays.asList(f,f2,f3));
        c.getFornecedores().add(f);
        c.getFornecedores().add(f2);
        c2.getFornecedores().add(f3);
        e.getCidades().add(c2);
        e.getCidades().add(c);
        cidaderepository.saveAll(Arrays.asList(c,c2));
        estadorepository.save(e);
        Funcionario func = new Funcionario();
        func.setEmail("vini@gmail.com");
        func.setLogin("vini030902");
        func.setNome("Vinicius Crispim de Azevedo");
        func.setSenha("123");
        func.setTelefone("45689-77778");
        funcionariorepository.save(func);
        NotaFiscal nf = new NotaFiscal();
        nf.setData(sdf.parse("10/05/2021"));
        nf.setFornecedor(f);
        nf.setValorTotal(10000.0);
        nfrepository.save(nf);
        f.getNotasfiscais().add(nf);
        OrdemCompra oc = new OrdemCompra();
        oc.setData(sdf.parse("09/05/2021"));
        oc.setFornecedor(f);
        oc.setValor(10000.0);
        ocrepository.save(oc);
        f.getOrdenscompra().add(oc);
        fornecedorrepository.save(f);
        Gerente g = new Gerente();
        g.setEmail("carlos@gmail.com");
        g.setNome("Carlos");
        g.setSenha("ca123");
        g.getFuncionarios().add(func);
        g.setTelefone("1324");
        g.setLogin("admCarlos234");
        gerenterepository.save(g);
        func.setGerente(g);
        funcionariorepository.save(func);
        CotacaoCompra coco = new CotacaoCompra();
        coco.setFornecedor(f);
        cotacomrepository.save(coco);
        CotacaoCompraItem cotaitens =  new CotacaoCompraItem(2,"BMW",p,coco,func,g); 
        CotacaoCompraItem cotaitens2 =  new CotacaoCompraItem(2,"Honda",p2,coco,func,g);
        cotaitensrepository.saveAll(Arrays.asList(cotaitens,cotaitens2));
        coco.getCotacaocompraitem().add(cotaitens);       
        OrdemCompraItem ordemcompraitens = new OrdemCompraItem(4,4500.0,p,oc);
        ocitemrepository.save(ordemcompraitens);
        NotaFiscalItem notafiscalitem = new NotaFiscalItem(4,4500.0,p,nf);
        nfitemrepository.save(notafiscalitem);
//        func.setNome("Davi Lima");
//        funcionariorepository.save(func);
//        fornecedorrepository.delete(f3);
    }
}
