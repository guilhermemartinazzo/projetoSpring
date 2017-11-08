function salvarProjeto(){
	var nome = $("#nome").val();
	var descricao = $("#descricao").val();
	var dtIni = $("#dtIni").val();
	var dtPrevTerm = $("#dtPrevTerm").val();
	var orcamento = $("#orcamento").val();
	var idgerente = $("#gerente").val();
	
	$.ajax({
		url: '/spring-boot-jsp-jpa/salvarProjeto?nome='+nome +
		'&descricao='+descricao+
		'&dtIni='+dtIni+
		'&dtPrevTerm='+dtPrevTerm+
		'&orcamento='+orcamento+
		'&idgerente='+idgerente,
		success: function(result){
			alert(result);
		}
	});
	
}