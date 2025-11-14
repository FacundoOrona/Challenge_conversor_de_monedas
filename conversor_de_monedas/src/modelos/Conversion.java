package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double monto;
    private double resultado;
    private LocalDateTime fecha;

    public Conversion(String monedaOrigen, String monedaDestino, double monto, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.monto = monto;
        this.resultado = resultado;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("[%s] %.2f %s → %.2f %s",
                fecha.format(formatter), monto, monedaOrigen, resultado, monedaDestino);
    }
}
