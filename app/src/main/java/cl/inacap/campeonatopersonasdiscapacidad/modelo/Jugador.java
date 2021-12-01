package cl.inacap.campeonatopersonasdiscapacidad.modelo;

public class Jugador {

    private String nombre;
    private String rut;
    private String altura;
    private String peso;
    private int edad;
    private String nacimiento;
    private String sexo;
    private String club ;
    private String discapacidad;

    //getter y setter / metodo constructor / toString


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Jugador(String nombre, String rut, String altura, String peso, int edad, String nacimiento, String sexo, String club, String discapacidad) {
        this.nombre = nombre;
        this.rut = rut;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
        this.club = club;
        this.discapacidad = discapacidad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                ", edad='" + edad + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", club='" + club + '\'' +
                ", discapacidad='" + discapacidad + '\'' +
                '}';
    }
}
