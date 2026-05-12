package lf1.plp.expressions2.expression;

import java.util.HashSet;
import java.util.Set;

import lf1.plp.expressions1.util.Tipo;
import lf1.plp.expressions1.util.TipoPrimitivo;
import lf1.plp.expressions2.memory.AmbienteCompilacao;
import lf1.plp.expressions2.memory.AmbienteExecucao;

public class ExpUnion implements Expressao {

    private Expressao exp1;
    private Expressao exp2;

    public ExpUnion(Expressao exp1, Expressao exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public Valor avaliar(AmbienteExecucao amb) {

        ValorSet set1 = (ValorSet) exp1.avaliar(amb);
        ValorSet set2 = (ValorSet) exp2.avaliar(amb);

        Set<Valor> resultado = new HashSet<Valor>(set1.valor());

        resultado.addAll(set2.valor());

        return new ValorSet(resultado);
    }

    public Tipo getTipo(AmbienteCompilacao amb) {
        return TipoPrimitivo.SET;
    }

    public boolean checaTipo(AmbienteCompilacao amb) {

        return exp1.getTipo(amb).eIgual(TipoPrimitivo.SET)
            && exp2.getTipo(amb).eIgual(TipoPrimitivo.SET);
    }

    public Expressao reduzir(AmbienteExecucao amb) {
        return this;
    }

    public Expressao clone() {
        return new ExpUnion(exp1, exp2);
    }
}