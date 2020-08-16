package managedBeanVarios;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YesithV
 */
public class Utilidades {

    /**
     * Retorne la fecha actual en el formato String establecido: yyyy-MM-dd
     * HH:mm:ss
     *
     * @return String: la fecha
     */
    public static String getFechaHoraActualString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaActual = new Date();
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-05"));
        String dateString = sdf.format(fechaActual);
        return dateString; 
    }

    /**
     * Convierte una fecha en formato Date en String
     *
     * @param fechaDate fecha en formato Date
     * @return fecha en formato String dd-MM-yyyy
     */
    public static String dateToString(Date fechaDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(fechaDate);
    }

    /**
     * Convierte una fecha en formato Date en String
     *
     * @param fechaDate fecha en formato Date
     * @return fecha en formato String dd-MM-yyyy
     */
    public static String dateToString2(Date fechaDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fechaDate);
    }

    /**
     * Retorne la fecha en el formato Date establecido: yyyy-MM-dd HH:mm:ss
     *
     * @return Date: la fecha actual
     */
    public static Date getFechaHoraActualDate() {
        Date fecha = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT-05"));
        try {
            fecha = df.parse(getFechaHoraActualString());
        } catch (ParseException e) {

        }
        return fecha;
    }

    /**
     * Metodo encargado de retornar la fecha actual en formato Date
     *
     * @return
     */
    public static Date getFechaActualDate() {
        Date fecha = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("GMT-05"));
        try {
            fecha = df.parse(getFechaHoraActualString());
        } catch (ParseException e) {

        }
        return fecha;
    }

    /**
     * Metodo encargado de subir una variable a sesion
     *
     * @param nombreVariable nombre de la variable a suir
     * @param valorVariable valor de la variable
     */
    public static void subiraSession(String nombreVariable, Object valorVariable) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute(nombreVariable, valorVariable);
    }

    /**
     * Metodo encargado de bajar un objeto de sesion, tener presente hacer el
     * casteo cada vez que se utilice este metodo
     *
     * @param nombreVariable variable a bajar de sesion
     * @return objeto encontrado en la sesion, recordar hacer el casteo
     */
    public static Object bajardeSession(String nombreVariable) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        HttpServletRequest peticion = (HttpServletRequest) contexto.getExternalContext().getRequest();
        HttpSession sesion = peticion.getSession(false);
        return sesion.getAttribute(nombreVariable);
    }

    /**
     * Metodo encargado de eliminar una varible de sesión
     *
     * @param nombreVariable variable a eliminar
     */
    public static void eliminardeSession(String nombreVariable) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        HttpServletRequest peticion = (HttpServletRequest) contexto.getExternalContext().getRequest();
        HttpSession sesion = peticion.getSession(false);
        sesion.removeAttribute(nombreVariable);
    }

    /**
     * Metodo encargado de redireccionar a una pagina solicitada, esta url debe
     * ser dentro del proyecto, NO aplica para url externas al proyecto
     *
     * @param rutaRedireccionar ruta dentro del proyecto
     * @throws IOException exepcion sin controlar
     */
    public static void redireccionar(String rutaRedireccionar) throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect(rutaRedireccionar);
    }

    /**
     * Metodo encargado de calcular el indice de masa corporal IMC a la persona
     *
     * @param estatura altura del paciente en centimetros
     * @param peso peso del paciente en kilogramos
     * @return IMC del paciente
     */
    public static float calcularIMC(Float peso, Float estatura) {
        Float denominador = estatura / 100;
        return peso / (denominador * denominador);
    }

    /**
     * Metodo encargado de retornar los años actuales que tiene la persona
     *
     * @param fechaNacimiento fecha de nacimiento
     * @return La cantidad de años que tiene el paciente
     */
    public static String calcularEdadActual(Date fechaNacimiento) {

        Period periodo = obtenerPeriodo(fechaNacimiento);
        return " " + periodo.getYears() + " años " + periodo.getMonths() + " meses " + periodo.getDays() + " días ";
    }

    /**
     * Metodo que calcula la edad en años de la persona
     *
     * @param fechaNacimiento fecha de nacimiento de la persona
     * @return int con la edad en años
     */
    public static int calcularAnnosPersona(Date fechaNacimiento) {
        Period periodo = obtenerPeriodo(fechaNacimiento);
        return periodo.getYears();
    }

    private static Period obtenerPeriodo(Date fechaNacimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-05"));
        String stringFechaNacimiento = sdf.format(fechaNacimiento);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(stringFechaNacimiento, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        return periodo;
    }

    /**
     * Metodo encargado de buscar el servidor y el puerto para retornar la url
     * absoluta de donde está alojado el sistema
     *
     * @return url completa del sistema
     */
    public static String getUrl() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        return "http://" + request.getServerName() + ":" + request.getLocalPort() + "/ClientesApp-web/";
    }

    /**
     * Metodo encargado de sumar o restar días a una fecha determinada
     *
     * @param fecha fecha con la que se va a trabajar
     * @param dias días que se quiere sumar o restar
     * @return resultado de la operación
     */
    public static Date sumarRestarDias(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }
    
}
