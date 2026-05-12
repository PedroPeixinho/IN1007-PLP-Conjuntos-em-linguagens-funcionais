package lf1.plp.expressions2.expression;

import java.util.Set;

import lf1.plp.expressions1.util.TipoPrimitivo;
import lf1.plp.expressions2.memory.AmbienteCompilacao;

public class ValorSet extends ValorConcreto<Set<Valor>> {

	public ValorSet(Set<Valor> valor) {
		super(valor);
	}

	public TipoPrimitivo getTipo(AmbienteCompilacao amb) {
		return TipoPrimitivo.SET;
	}

	public ValorSet clone() {
		return new ValorSet(this.valor());
	}

	@Override
	public String toString() {

		String resultado = "{";
		boolean primeiro = true;

		for (Valor v : valor()) {

			if (!primeiro) {
				resultado += ", ";
			}

			resultado += v.toString();
			primeiro = false;
		}

		resultado += "}";

		return resultado;
	}
}