import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ImoobiliariaApp {

	private ImoobiliariaApp() {}

	private static Imoobiliaria empresa;
	
	private static Menu menuPrincipal, menuComprador, menuVendedor, menuRegistar,
                                       menuImovel;

	public static void main(String[] args) {
		carregarMenus();
		carregarDados();
		executaMenuPrincipal();
		try {
			empresa.gravar();
		}
		catch (IOException e) {
			System.out.println("Não foi possível guardar os dados");
		}
	}
	
	private static void carregarMenus() {
		String[] principal = {"Iniciar Sessão",
							  "Registar utilizador",
							  "Procurar imóveis por tipo",
							  "Procurar imóveis habitáveis",
							  "Mapear imóveis"};

		String[] comprador = {"Procurar imóveis por tipo",
							  "Procurar imóveis habitáveis",
							  "Mapear imóveis",
							  "Adicionar imóvel aos favoritos",
							  "Obter lista de favoritos",
							  "Fechar sessão"};

		String[] vendedor = {"Procurar imóveis por tipo",
							 "Procurar imóveis habitáveis",
							 "Mapear Imóveis",
							 "Registar imóvel",
							 "Obter últimas consultas",
							 "Obter imóveis mais consultados",
							 "Mudar estado de imóvel",
							 "Iniciar leilão",
							 "Adicionar comprador ao leilão",
							 "Encerrar leilão",
							 "Fechar sessão"};

		String[] registar = {"Registar comprador",
							 "Registar vendedor"};

		String[] imovel = {"Moradia",
						   "Apartamento",
                           "Loja",
                           "Loja habitável", 
						   "Terreno"};

		menuPrincipal = new Menu(principal);
		menuComprador = new Menu(comprador);
		menuVendedor = new Menu(vendedor);
		menuRegistar = new Menu(registar);
		menuImovel = new Menu(imovel);
	}

	private static void executaMenuPrincipal() {
		do {
			menuPrincipal.executa();
			switch(menuPrincipal.getOpcao()) {
				case 1: iniciarSessao(); break;
				case 2: registarUtilizador(); break;
				case 3: imoveisPorTipo(); break;
				case 4: imoveisHabitaveis(); break;
				case 5: mapearImoveis(); break;
			}
		} while(menuPrincipal.getOpcao() != 0);
	}

	private static void executaMenuComprador() {
		do {
			menuComprador.executa();
			switch(menuComprador.getOpcao()) {
				case 1: imoveisPorTipo(); break;
				case 2: imoveisHabitaveis(); break;
				case 3: mapearImoveis(); break;
				case 4: adicionarFavorito(); break;
				case 5: obterFavoritos(); break;
				case 6: empresa.fechaSessao(); break;
			}
		} while(menuComprador.getOpcao() != 6);

	}

	private static void executaMenuVendedor() {
		do {
			menuVendedor.executa();
			switch(menuVendedor.getOpcao()) {
				case  1: imoveisPorTipo(); break;
				case  2: imoveisHabitaveis(); break;
				case  3: mapearImoveis(); break;
				case  4: registarImovel(); break;
				case  5: obterUltimasConsultas(); break;
				case  6: imoveisMaisConsultados(); break;
				case  7: mudarEstado(); break;
				case  8: iniciarLeilao(); break;
				case  9: adicionarComprador(); break;
				case 10: encerrarLeilao(); break;
				case 11: empresa.fechaSessao(); break;
			}
		} while(menuVendedor.getOpcao() != 11);
	}

	private static void iniciarLeilao() {
		Scanner input = new Scanner(System.in);
		int horas = lerInt("Número de horas: ");

		Moradia im = new Moradia();
		im.setRua(Long.toString(System.currentTimeMillis()));

		try {
			empresa.registaImovel(im);
			empresa.iniciaLeilao(im, horas);
		}catch (SemAutorizacaoException | ImovelExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void adicionarComprador() {
	    Scanner input = new Scanner(System.in);
		System.out.print("ID do Comprador: ");
		String id = input.nextLine();

		double limite = lerDouble("Limite máximo: ");
		double incrementos = lerDouble("Incrementos: ");
		double intervalo = lerDouble("Intervalo entre licitações: ");

		try {
			empresa.adicionaComprador(id, limite, incrementos, intervalo);
		}
		catch(LeilaoTerminadoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void encerrarLeilao() {
		Comprador c = empresa.encerraLeilao();

		System.out.println("\nVencedor: " + c.getEmail() + "\n");
	}

	private static void carregarDados() {
		try {
			empresa = Imoobiliaria.initApp();
		}
		catch(IOException e) {
			empresa = new Imoobiliaria();
			System.out.println("Não foi possível ler os dados guardados!\nErro de leitura!");
		}
		catch(ClassNotFoundException e) {
			empresa = new Imoobiliaria();
			System.out.println("Não foi possível ler os dados guardados!\nFicheiro com formato desconhecido!");
		}
		catch(ClassCastException e) {
			empresa = new Imoobiliaria();
			System.out.println("Não foi possível ler os dados guardados!\nErro de formato!");
		}
	}

	private static void registarUtilizador() {
		String email, nome, password, morada;
		LocalDate dataNascimento;
		Scanner input = new Scanner(System.in);
		Utilizador u = null;

		menuRegistar.executa();
		if (menuRegistar.getOpcao() == 0) {
			System.out.println("Registo cancelado");
			return;
		}

		System.out.print("Email: ");
		email = input.nextLine();

		System.out.print("Nome: ");
		nome = input.nextLine();

		System.out.print("Password: ");
		password = input.nextLine();

		System.out.print("Morada: ");
		morada = input.nextLine();

		dataNascimento = lerData("Data de nascimento (dd-MM-yyyy): ");

		switch(menuRegistar.getOpcao()) {
			case 0: input.close(); return;
			case 1: u = new Comprador(); break;
			case 2: u = new Vendedor(); break;
		}

		u.setEmail(email);
		u.setNome(nome);
		u.setPassword(password);
		u.setMorada(morada);
		u.setDataNascimento(dataNascimento);

		try {	
			empresa.registarUtilizador(u);
		}
		catch (UtilizadorExistenteException e) {
			System.out.println(e.getMessage());
		}
			
		finally {
			input.close();
		}

	}

	private static void iniciarSessao() {
		Scanner input = new Scanner(System.in);
		String email, password;

		System.out.print("Email: ");
		email = input.nextLine();

		System.out.print("Password: ");
		password = input.nextLine();

		try {
			empresa.iniciaSessao(email, password);
		}
		catch (SemAutorizacaoException e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			input.close();
		}

		switch (empresa.getTipoUtilizador()) {
			case 1: executaMenuComprador(); break;
			case 2: executaMenuVendedor(); break;
		}
	}

	private static void imoveisPorTipo() {
		Scanner input = new Scanner(System.in);
		String classe;
		int precoMaximo;
		List<Imovel> lista;

		System.out.print("Tipo de imóvel: ");
		classe = input.nextLine();
		input.close();

		precoMaximo = lerInt("Preço máximo: ");

		lista = empresa.getImovel(classe, precoMaximo);

		System.out.print("\n");
		for(Imovel im: lista)
			System.out.println(im.toString());
	}
	
	private static void imoveisMaisConsultados() {
		Scanner input = new Scanner(System.in);
		Set<String> topImoveis;
		int n = lerInt("Número mínimo de consultas: ");

		try {
			topImoveis = empresa.getTopImoveis(n);

			System.out.print("\n");
			for(String s: topImoveis)
				System.out.println("ID: " + s);
		}
		catch (SemAutorizacaoException e) {
			System.out.println(e.getMessage());
		}

		finally {
			input.close();
		}
	}

	private static void imoveisHabitaveis() {
		int precoMaximo;
		List<Habitavel> lista;

		precoMaximo = lerInt("Preço máximo: ");

		lista = empresa.getHabitaveis(precoMaximo);

		for(Habitavel h: lista)
			System.out.print("\n" + h.toString());
	}

	private static void mapearImoveis() {
		Set<Map.Entry<Imovel, Vendedor>> map = empresa.getMapeamentoImoveis().entrySet();

		System.out.print("\n");

		for(Map.Entry<Imovel, Vendedor> entry: map) {
			System.out.println("Email: " + entry.getValue().getEmail()+"\n");
			System.out.println(entry.getKey().toString());	
		}
	}

	private static void obterUltimasConsultas() {
		try {
			List<Consulta> consultas = empresa.getConsultas();

			System.out.print("\n");
			for(Consulta c: consultas)
				System.out.println(c.toString());
		}
		catch(SemAutorizacaoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void adicionarFavorito() {
		Scanner input = new Scanner(System.in);
		String imovelId;

		System.out.println("ID do imovel: ");
		imovelId = input.nextLine();

		try {
			empresa.setFavorito(imovelId);
		}
		catch (ImovelInexistenteException | SemAutorizacaoException e) {
			System.out.println(e.getMessage());
		}
	
		finally {
			input.close();
		}	
	}

	private static void obterFavoritos() {
		TreeSet<Imovel> fav;

		try {
			fav = empresa.getFavoritos();
		}
		catch (SemAutorizacaoException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.print("\n");
		for(Imovel im: fav)
			System.out.println(im.toString());
		
	}

	private static void mudarEstado() {
		Scanner input = new Scanner(System.in);
		String estado, idImovel;

		System.out.print("Id do imóvel: ");
		idImovel = input.nextLine();

		System.out.print("Novo estado: ");
		estado = input.nextLine();

		try {
			empresa.setEstado(idImovel, estado);
		}
		catch(SemAutorizacaoException | ImovelInexistenteException | 
              EstadoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		finally {
			input.close();
		}
	}

	private static void registarImovel() {
		Imovel im = null;

		menuImovel.executa();
		if (menuImovel.getOpcao() == 0) {
			System.out.println("Registo cancelado");
			return;
		}

		switch(menuImovel.getOpcao()) {
			case 1: im = lerMoradia(); break;
			case 2: im = lerApartamento(); break;
			case 3: im = lerLoja(); break;
			case 4: im = lerLojaHabitavel(); break;
			case 5: im = lerTerreno(); break;
		}

		try {
			empresa.registaImovel(im);
		}
		catch(ImovelExisteException | SemAutorizacaoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Imovel lerMoradia() {
		Scanner input = new Scanner(System.in);
		Moradia im = new Moradia();

		System.out.print("Rua: ");
		String rua = input.nextLine();

		System.out.print("Tipo: ");
		String tipo = input.nextLine();

		int porta = lerInt("Porta: ");
		int quartos = lerInt("Número de quartos: ");
		int wc = lerInt("Número de casas de banho: ");
		double areaImplantacao = lerDouble("Área de implantação: ");
		double areaCoberta = lerDouble("Área coberta: ");
		double areaTerreno = lerDouble("Área do terreno: ");
		int precoMinimo = lerInt("Preço mínimo: ");
		int precoPedido = lerInt("Preço pedido: ");
		
		im.setRua(rua);
		im.setPorta(porta);
		im.setTipo(tipo);
		im.setQuartos(quartos);
		im.setWC(wc);
		im.setAreaImplantacao(areaImplantacao);
		im.setAreaCoberta(areaCoberta);
		im.setAreaTerreno(areaTerreno);
		im.setPrecoMinimo(precoMinimo);
		im.setPrecoPedido(precoPedido);

		input.close();
		return im;
	}

	private static Imovel lerApartamento() {
		Scanner input = new Scanner(System.in);
		Apartamento im = new Apartamento();

		System.out.print("Rua: ");
		String rua = input.nextLine();

		int porta = lerInt("Porta: ");
		int andar = lerInt("Andar: ");

		System.out.print("Tipo: ");
		String tipo = input.nextLine();

		double area = lerDouble("Área m²: ");
		int quartos = lerInt("Número de quartos: ");
		int wc = lerInt("Número de casas de banho: ");
		boolean garagem = lerBoolean("Garagem (s/n): ");
		int precoMinimo = lerInt("Preço mínimo: ");
		int precoPedido = lerInt("Preço pedido: ");
	
		im.setRua(rua);
		im.setPorta(porta);
		im.setAndar(andar);
		im.setTipo(tipo);
		im.setArea(area);
		im.setQuartos(quartos);
		im.setWC(wc);
		im.setGaragem(garagem);
		im.setPrecoMinimo(precoMinimo);
		im.setPrecoPedido(precoPedido);
	
		input.close();
		return im;

	}

	private static Imovel lerLoja() {
		Scanner input = new Scanner(System.in);
		Loja im = new Loja();

		System.out.print("Rua: ");
		String rua = input.nextLine();

		int porta = lerInt("Porta: ");

		System.out.print("Tipo: ");
		String tipo = input.nextLine();

		double area = lerDouble("Área: ");
		boolean wc = lerBoolean("Casa de banho (s/n): ");
		int precoMinimo = lerInt("Preço mínimo: ");
		int precoPedido = lerInt("Preço pedido: ");
		
		input.close();

		im.setRua(rua);
		im.setPorta(porta);
		im.setTipo(tipo);
		im.setArea(area);
		im.setWC(wc);
		im.setPrecoMinimo(precoMinimo);
		im.setPrecoPedido(precoPedido);

		return im;
	}

	private static Imovel lerLojaHabitavel() {
		Scanner input = new Scanner(System.in);
		LojaHabitavel im = new LojaHabitavel();

		System.out.print("Rua: ");
		String rua = input.nextLine();

		int porta = lerInt("Porta: ");

		System.out.print("Tipo: ");
		String tipo = input.nextLine();

		double area = lerDouble("Área: ");
		boolean wc = lerBoolean("Casa de banho (s/n): ");

		System.out.print("Tipo de apartamento: ");
		String tipoApartamento = input.nextLine();

		double areaApartamento = lerDouble("Área do apartamento (m²): ");
		int quartos = lerInt("Número de quartos: ");
		int wcApartamento = lerInt("Número de wc no apartamento: ");
		int andar = lerInt("Andar da parte habitável: ");		
		int precoMinimo = lerInt("Preço mínimo: ");
		int precoPedido = lerInt("Preço pedido: ");
	
		im.setRua(rua);
		im.setTipo(tipo);
		im.setArea(area);
		im.setWC(wc);
		im.setTipoApartamento(tipoApartamento);
		im.setAreaApartamento(areaApartamento);
		im.setQuartos(quartos);
		im.setWcApartamento(wcApartamento);
		im.setAndar(andar);
		im.setPrecoMinimo(precoMinimo);
		im.setPrecoPedido(precoPedido);
	
		input.close();
		return im;
	}

	private static Imovel lerTerreno() {
		Scanner input = new Scanner(System.in);
		Terreno im = new Terreno();

		System.out.print("Rua: ");
		String rua = input.nextLine();

		System.out.print("Tipo: ");
		String tipo = input.nextLine();

		double area = lerDouble("Área: ");
		double diametroCanalizacao = lerDouble("Diâmetro da canalização (mm): ");
		double potenciaSuportada = lerDouble("Potência potenciaSuportada (KWh): ");
		boolean acessoEsgotos = lerBoolean("Acesso a esgotos (s/n): ");
		int precoMinimo = lerInt("Preço mínimo: ");
		int precoPedido = lerInt("Preço pedido: ");

		im.setRua(rua);
		im.setTipo(tipo);
		im.setArea(area);
		im.setDiametroCanalizacao(diametroCanalizacao);
		im.setPotenciaSuportada(potenciaSuportada);
		im.setPrecoMinimo(precoMinimo);
		im.setPrecoPedido(precoPedido);
	
		input.close();
		return im;
	}

	private static LocalDate lerData(String msg) {
		Scanner input = new Scanner(System.in);
		String aux;
		LocalDate data;

		System.out.print(msg);
		aux = input.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		try {
			data = LocalDate.parse(aux, formatter);
		}
		catch (DateTimeParseException e) {
			System.out.println("Formato da data incorreto\n");
			data = lerData(msg);
		}

		finally {
			input.close();
		}

		return data;
	}

	private static double lerDouble(String msg) {
		Scanner input = new Scanner(System.in);
		double d = 0.0;

		System.out.print(msg);
		try {
			d = input.nextDouble();
		}
		catch (InputMismatchException e) {
			System.out.println("Formato incorreto");
			d = lerDouble(msg);
		}
	
		finally {
			input.close();
		}

		return d;
	}

	private static int lerInt(String msg) {
		Scanner input = new Scanner(System.in);
		int d = 0;

		System.out.print(msg);
		try {
			d = input.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Formato incorreto");
			d = lerInt(msg);
		}
	
		finally {
			input.close();
		}

		return d;
	}

	private static boolean lerBoolean(String msg) {
		Scanner input = new Scanner(System.in);
		String s;
		boolean res = true;

		System.out.print(msg);
		s = input.nextLine();

		if (s.charAt(0) == 'n')
			res = false;

		input.close();
		return res;	
	}
}
