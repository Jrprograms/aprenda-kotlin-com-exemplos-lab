enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(var nome: String, val email: String, val senha: String){
    override fun toString(): String{
		return this.nome
    }
}

data class ConteudoEducacional(val nome: String, val duracaoMinutos: Float = 60f, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional> ) {

    val inscritos = mutableListOf<Usuario>()
    
    override fun toString(): String{
        return (this.nome)
    }
    
    fun matricular(usuario: Usuario): Unit {
        this.inscritos.add(usuario)
        println("Usuario $usuario adicionado!")
        println(this.inscritos)
    }
    
    fun qtdMatriculas(): Unit{
		println(this.inscritos.size)
    }
    
    fun removerMatricula(usuario: Usuario): Unit{
		if(this.inscritos.remove(usuario)){
			println("Usuario $usuario removido da formação $this com sucesso!")
        }else{
			println("Usuário $usuario não encontrado")
        }
    }
}

fun main() {
    //Inicialização de variáveis
    val usuario = Usuario("Joao","Batata@gmail.com","1234")
    val usuario2 = Usuario("Alisson", "DIO@gmail.com","1234")
    val usuario3 = Usuario("Joao","email@gmail.com","5421")
    
    val aprendendoLogica = ConteudoEducacional("Aprendendo Logica",80f, Nivel.BASICO)
    val aprendendoJs = ConteudoEducacional("Aprendendo JavaScript",120f, Nivel.INTERMEDIARIO)
    val conteudo: List<ConteudoEducacional> = listOf(aprendendoLogica, aprendendoJs)
    val react = Formacao("React para iniciantes", conteudo)
    
    //Teste de métodos
    
    //Matriculando e removendo usuario
    react.matricular(usuario)
    react.qtdMatriculas()
    
    react.removerMatricula(usuario)
    react.qtdMatriculas()
    
    //Tentativa de matricular um usuario com um mesmo nome
    react.matricular(usuario)
    
    //Remover um usuário não matriculado
    react.removerMatricula(usuario2)
    
}