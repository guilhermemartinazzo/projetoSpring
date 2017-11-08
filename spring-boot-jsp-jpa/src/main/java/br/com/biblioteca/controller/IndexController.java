package br.com.biblioteca.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.DAO;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;

@Controller
public class IndexController {
	
	@Autowired
	private DAO<Pessoa> pessoaDao;
	
	@Autowired
	private DAO<Projeto> projetoDao;

	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public ModelAndView index() {
				List<Pessoa> pessoas = pessoaDao.findAll(Pessoa.class);
				List<Projeto> projetos = projetoDao.findAll(Projeto.class);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaVazia", projetos.isEmpty());
		mv.addObject("listaProjetos",projetos);
		mv.addObject("listaPessoas",pessoas);
		
		return mv;
	}
	
	@RequestMapping("/salvarProjeto")
	@ResponseBody
	public String save(@RequestParam("nome") String nome,
			@RequestParam("descricao") String descricao,
			@RequestParam("dtIni") String dtIni,
			@RequestParam("dtPrevTerm") String dtPrevTerm,
			@RequestParam("orcamento") String orcamento,
			@RequestParam("idgerente") String idgerente
			)  throws Exception{
		Projeto projeto = new Projeto();
		projeto.setNome(nome);
		projeto.setDescricao(descricao);
		projeto.setDataInicio(new SimpleDateFormat("yyyy-MM-dd").parse(dtIni));
		projeto.setDataPrevisaoFim(new SimpleDateFormat("yyyy-MM-dd").parse(dtPrevTerm));
		projeto.setOrcamento(Double.valueOf(orcamento));
		projeto.setIdGerente(Long.valueOf(idgerente));
		
		Projeto save = projetoDao.save(projeto);
		if(save != null){
			index();
			return "Projeto: "+save.getId()+" - "+save.getNome()+"\n Salvo com sucesso!";
		}
			return "Projeto não salvo";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/listarProjetos")
	public ModelAndView listarProjetos(){
		List<Projeto> projetos = projetoDao.findAll(Projeto.class);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listaVazia", true);
		if(projetos!= null && !projetos.isEmpty()){
			mv.addObject("listaProjetos", projetos);
			mv.addObject("listaVazia", false);
		}
		return mv;
	}
	
}
