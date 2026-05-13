package lf1.plp.expressions2.expression;

import java.util.HashSet;
import java.util.Set;

import lf1.plp.expressions1.util.Tipo;
import lf1.plp.expressions1.util.TipoPrimitivo;
import lf1.plp.expressions2.memory.AmbienteCompilacao;
import lf1.plp.expressions2.memory.AmbienteExecucao;

public class ExpUnionAll extends ExpBinaria {

    public ExpUnionAll(Expressao exp) {
        super(exp, null, "unionAll");
    }

    @Override
    public Valor avaliar(AmbienteExecucao amb) {

        ValorSet conjuntoExterno = (ValorSet) esq.avaliar(amb);

        Set<Valor> resultado = new HashSet<Valor>();

        for (Valor valor : conjuntoExterno.valor()) {

            ValorSet conjuntoInterno = (ValorSet) valor;

            resultado.addAll(conjuntoInterno.valor());
        }

        return new ValorSet(resultado);
    }

    @Override
    public Tipo getTipo(AmbienteCompilacao amb) {
        return TipoPrimitivo.SET;
    }

    @Override
    public Expressao reduzir(AmbienteExecucao amb) {
        return this;
    }

    @Override
    public boolean checaTipo(AmbienteCompilacao amb) {
        return true;
    }

    @Override
    public ExpUnionAll clone() {
        return new ExpUnionAll(esq);
    }

    @Override
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) {
        return true;
    }
}