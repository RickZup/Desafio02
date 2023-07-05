public interface Validacoes {

    public default void validarEmail(String email){
        if (!email.contains("@")){
            throw new IllegalArgumentException("E-mail inválido!");
        }
    }
}
