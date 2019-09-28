
public class BoundaryCotacao {

	public static void main(String[] args) {
		ControllerCotacao controller = new ControllerCotacao();

		// pré-requisitos
		controller.registrarEscola("PUC", "Marques de Paranagua", "123");
		controller.registrarListaMaterial(controller.escolas.get(0), "EE", 2019);
		controller.registrarLoja("Papelaria PUC", "Marques de Paranagua", "123");

		// registrar cotação
		controller.registrarCotacao(controller.escolas.get(0).listasmateriais.get(0), controller.lojas.get(0));

		// exibir valores
		System.out.println(controller.mostrarEscolas());
		System.out.println(controller.mostrarListasMateriais());
		System.out.println(controller.mostrarLojas());
		System.out.println(controller.mostrarCotacoes());
	}

}