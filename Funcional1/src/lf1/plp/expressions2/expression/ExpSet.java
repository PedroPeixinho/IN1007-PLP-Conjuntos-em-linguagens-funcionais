package lf1.plp.expressions2.expression;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lf1.plp.expressions1.util.Tipo;
import lf1.plp.expressions1.util.TipoPrimitivo;
import lf1.plp.expressions2.memory.AmbienteCompilacao;
import lf1.plp.expressions2.memory.AmbienteExecucao;

public class ExpSet implements Expressao {

    private List<Expressao> expressoes;

    public ExpSet(List<Expressao> expressoes) {
        this.expressoes = expressoes;
    }

    public Valor avaliar(AmbienteExecucao amb) {

        Set<Valor> valores = new HashSet<Valor>();

        for (Expressao exp : expressoes) {
            valores.add(exp.avaliar(amb));
        }

        return new ValorSet(valores);
    }

    public Tipo getTipo(AmbienteCompilacao amb) {
        return TipoPrimitivo.SET;
    }

    public boolean checaTipo(AmbienteCompilacao amb) {
        return true;
    }

    public Expressao reduzir(AmbienteExecucao amb) {
        return this;
    }

    public Expressao clone() {
        return new ExpSet(this.expressoes);
    }
}