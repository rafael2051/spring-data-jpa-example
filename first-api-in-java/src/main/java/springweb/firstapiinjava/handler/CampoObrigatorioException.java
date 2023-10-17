package springweb.firstapiinjava.handler;

public class CampoObrigatorioException extends BusinessException{
    public CampoObrigatorioException(String campo){
        super("O campo %s e obrigatorio", campo);
    }
}
