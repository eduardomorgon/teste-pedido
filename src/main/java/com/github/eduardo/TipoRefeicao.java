package com.github.eduardo;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public enum TipoRefeicao {
    
    MANHA(new PratoManha()),
    NOITE(new PratoNoite());
    
    private final Prato prato;

    private TipoRefeicao(Prato prato) {
        this.prato = prato;
    }
    
    public Prato getPrato() {
        return prato;
    }
}