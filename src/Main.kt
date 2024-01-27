import kotlin.math.roundToInt

class Persona(
    val peso:Double,
    var altura:Double
){
    var nombre:String = ""
        set(value) {
            require(nombre.isBlank()) { "El nombre no puede ser nulo" }
            field = value
        }

    private var imc = peso / (altura*2)

    constructor(peso: Double,altura: Double,nombre:String):this(peso,altura){
        this.nombre = nombre
    }


    override fun toString(): String {
        return """Persona: 
        peso: $peso
        altura: ${String.format("%.2f",this.imc)}
        imc: $imc 
        nombre: $nombre"""
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        if (this.nombre != other.nombre) return false
        if (this.altura != other.altura) return false
        if (this.peso != other.peso) return false
        return false
    }

    fun saludar():String{
        return "Hola, soy ${this.nombre}"
    }

    private fun alturaEncimaMedia():Boolean {
        return if (this.altura >= 1.75 ) true else false
    }

    private fun comprobaraltura(tal:Boolean):String{
        return if(tal) "Por encima de la media" else "Por debajo de la media"
    }

    private fun PesoEncimaMedia():Boolean {
        return if (this.peso >= 70.0 ) true else false
    }

    private fun comprobarpeso(tal:Boolean):String{
        return if(tal) "Por encima de la media" else "Por debajo de la media"
    }


    fun obtenerDesc():String {
        return "$nombre con una altura de ${altura}m (${comprobaraltura(alturaEncimaMedia())}) y un peso ${peso}kg (${comprobarpeso(PesoEncimaMedia())}) tiene un IMC de ${String.format("%.2f",this.imc)} (${obtenerDescImc()})."
    }


    private fun obtenerDescImc():String{
        return when (this.imc) {
            in 1.0..18.5 -> "peso insuficiente"
            in 18.6..24.9-> "peso saludable"
            in 25.0..29.9-> "sobrepeso"
            else -> {
                if (this.imc > 30) {
                    "Obesidad"
                }else{
                    "IMC Inexistente"
                }
            }
        }
    }



}

fun main() {
    val persona1 = Persona(69.2,1.72,"Jose angel")
    println(persona1.saludar())
    println(persona1.obtenerDesc())
    println()

    val persona2 = Persona(32.1,0.72,"Diego")
    println(persona2.saludar())
    println(persona2.obtenerDesc())
    println()

    val persona3 = Persona(80.4,1.92,"Ivan")
    println(persona3.saludar())
    println(persona3.obtenerDesc())
    println()

    val persona4 = Persona(78.2,1.81,"Catalan")
    println(persona4.saludar())
    println(persona4.obtenerDesc())
    println()

    val persona5 = Persona(1.2,0.23,"Luis")
    println(persona5.saludar())
    println(persona5.obtenerDesc())
    println()
}