import kotlin.math.roundToInt
/**
 * Clase que representa una persona con propiedades como peso, altura y nombre.
 *
 * @property peso El peso de la persona.
 * @property altura La altura de la persona.
 * @property nombre El nombre de la persona.
 *
 * @constructor Crea un objeto [Persona] con el peso y la altura especificados.
 * @param peso El peso de la persona.
 * @param altura La altura de la persona.
 *
 * @constructor Crea un objeto [Persona] con el peso, la altura y el nombre especificados.
 * @param peso El peso de la persona.
 * @param altura La altura de la persona.
 * @param nombre El nombre de la persona.
 */

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

    /**
     * Constructor secundario que permite proporcionar también el nombre al crear una persona.
     */
    constructor(peso: Double,altura: Double,nombre:String):this(peso,altura){
        this.nombre = nombre
    }

    /**
     * Representación en cadena del objeto [Persona].
     *
     * @return Una cadena que representa el peso, la altura, el IMC y el nombre de la persona.
     */
    override fun toString(): String {
        return """Persona: 
        peso: $peso
        altura: ${String.format("%.2f",this.imc)}
        imc: $imc 
        nombre: $nombre"""
    }

    /**
     * Compara si dos objetos [Persona] son iguales.
     *
     * @return `true` si los objetos son iguales, `false` en caso contrario.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false

        if (this.nombre != other.nombre) return false
        if (this.altura != other.altura) return false
        if (this.peso != other.peso) return false
        return false
    }

    /**
     * Saluda a la persona.
     *
     * @return Un saludo personalizado.
     */
    fun saludar():String{
        return "Hola, soy ${this.nombre}"
    }

    /**
     * Verifica si la altura de la persona está por encima de la media.
     *
     * @return `true` si la altura es por encima de la media, `false` en caso contrario.
     */
    private fun alturaEncimaMedia():Boolean {
        return if (this.altura >= 1.75 ) true else false
    }

    /**
     * Comprueba si la altura está por encima o por debajo de la media.
     *
     * @param tal Booleano que indica si la altura está por encima de la media.
     * @return Una cadena indicando si la altura está por encima o por debajo de la media.
     */
    private fun comprobaraltura(tal:Boolean):String{
        return if(tal) "Por encima de la media" else "Por debajo de la media"
    }

    /**
     * Verifica si el peso de la persona está por encima de la media.
     *
     * @return `true` si el peso es por encima de la media, `false` en caso contrario.
     */
    private fun PesoEncimaMedia():Boolean {
        return if (this.peso >= 70.0 ) true else false
    }

    /**
     * Comprueba si el peso está por encima o por debajo de la media.
     *
     * @param tal Booleano que indica si el peso está por encima de la media.
     * @return Una cadena indicando si el peso está por encima o por debajo de la media.
     */
    private fun comprobarpeso(tal:Boolean):String{
        return if(tal) "Por encima de la media" else "Por debajo de la media"
    }

    /**
     * Obtiene una descripción detallada de la persona, incluyendo información sobre altura, peso, IMC y clasificación del IMC.
     *
     * @return Una cadena con la descripción detallada de la persona.
     */
    fun obtenerDesc():String {
        return "$nombre con una altura de ${altura}m (${comprobaraltura(alturaEncimaMedia())}) y un peso ${peso}kg (${comprobarpeso(PesoEncimaMedia())}) tiene un IMC de ${String.format("%.2f",this.imc)} (${obtenerDescImc()})."
    }

    /**
     * Obtiene la descripción de la clasificación del IMC.
     *
     * @return Una cadena con la clasificación del IMC.
     */
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

/**
 * Función principal que crea varios objetos [Persona] y los imprime.
 */
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