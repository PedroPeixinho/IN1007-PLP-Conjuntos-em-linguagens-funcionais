package lf1.plp.expressions2.expression;

import lf1.plp.expressions1.util.Tipo;
import lf1.plp.expressions1.util.TipoPrimitivo;
import lf1.plp.expressions2.memory.AmbienteCompilacao;
import lf1.plp.expressions2.memory.AmbienteExecucao;

public class ExpIn implements Expressao {

    private Expressao elemento;
    private Expressao conjunto;

    public ExpIn(Expressao elemento, Expressao conjunto) {
        this.elemento = elemento;
        this.conjunto = conjunto;
    }

    public Valor avaliar(AmbienteExecucao amb) {

        Valor valElemento = elemento.avaliar(amb);
        Valor valConjunto = conjunto.avaliar(amb);

        ValorSet set = (ValorSet) valConjunto;

        boolean contem = set.valor().contains(valElemento);

        return new ValorBooleano(contem);
    }

    public Tipo getTipo(AmbienteCompilacao amb) {
        return TipoPrimitivo.BOOLEANO;
    }

    public boolean checaTipo(AmbienteCompilacao amb) {
        return conjunto.getTipo(amb).eIgual(TipoPrimitivo.SET);
    }

    public Expressao reduzir(AmbienteExecucao amb) {
        return this;
    }

    public Expressao clone() {
        return new ExpIn(elemento, conjunto);
    }
}