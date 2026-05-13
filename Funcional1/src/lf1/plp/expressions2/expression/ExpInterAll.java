package lf1.plp.expressions2.expression;

import java.util.HashSet;
import java.util.Set;

import lf1.plp.expressions1.util.Tipo;
import lf1.plp.expressions1.util.TipoPrimitivo;
import lf1.plp.expressions2.memory.AmbienteCompilacao;
import lf1.plp.expressions2.memory.AmbienteExecucao;

public class ExpInterAll extends ExpUnaria {

    public ExpInterAll(Expressao exp) {
        super(exp, "interAll");
    }

    public Valor avaliar(AmbienteExecucao amb) {

        ValorSet conjuntoDeConjuntos =
            (ValorSet) exp.avaliar(amb);

        Set<Valor> conjuntos = conjuntoDeConjuntos.valor();

        Set<Valor> resultado = null;

        for (Valor v : conjuntos) {

            ValorSet interno = (ValorSet) v;

            if (resultado == null) {
                resultado = new HashSet<Valor>(interno.valor());
            } else {
                resultado.retainAll(interno.valor());
            }
        }

        if (resultado == null) {
            resultado = new HashSet<Valor>();
        }

        return new ValorSet(resultado);
    }

    public Tipo getTipo(AmbienteCompilacao amb) {
        return TipoPrimitivo.SET;
    }

    protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) {
        return exp.getTipo(amb).eIgual(TipoPrimitivo.SET);
    }

    public ExpUnaria clone() {
        return new ExpInterAll(exp.clone());
    }
}