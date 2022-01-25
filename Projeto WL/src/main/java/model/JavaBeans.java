package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The idcon. */
	private String idcon;
	
	/** The nome. */
	private String nome;
	
	/** The cpf. */
	private String cpf;
	
	/** The item. */
	private String item;

	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}

	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcon the idcon
	 * @param nome the nome
	 * @param cpf the cpf
	 * @param item the item
	 */
	public JavaBeans(String idcon, String nome, String cpf, String item) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.cpf = cpf;
		this.item = item;
	}

	/**
	 * Gets the idcon.
	 *
	 * @return the idcon
	 */
	public String getIdcon() {
		return idcon;
	}

	/**
	 * Sets the idcon.
	 *
	 * @param idcon the new idcon
	 */
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param item the new item
	 */
	public void setItem(String item) {
		this.item = item;
	}
}