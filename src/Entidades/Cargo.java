package Entidades;

/**
 *
 * @author gu_sc
 */
public enum Cargo {
    vendedor,gerente;
    
    public static Cargo getCargo(int cargo){
        switch (cargo) {
            case 2:
                return Cargo.vendedor;
            case 1:
                return Cargo.gerente;
            default:
                return null;
        }
    }
}
