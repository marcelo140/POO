/**
 * Comparator de Imovel - ordenação por preços
 */

import java.util.Comparator;

public class ComparatorImovelByPreco implements Comparator<Imovel> {
	public int compare(Imovel im1, Imovel im2) {
		return (int) (im1.getPrecoPedido() - im2.getPrecoPedido());
	}
}
