package PaymentRollModel;

import java.util.ArrayList;
import java.util.List;

public class FolhaDePagamento
{
	//List<FolhaDePagamento> folhaDePagamentos = new ArrayList();
	List<FolhaDePagamento> folhaDePagamentos = new ArrayList<FolhaDePagamento>();
	public Funcionario Funcionario;
	public int Mes;
    public int Ano;
    public int HorasTrabalhadas;
    public float ValorHora;
    
    public FolhaDePagamento()
    {
		Funcionario = new Funcionario();
    }
    
    public Funcionario getFuncionario() 
    {
		return Funcionario;
	}
    
	public void setFuncionario(Funcionario funcionario) 
	{
		Funcionario = funcionario;
	}
	
	public int getMes() 
	{
		return Mes;
	}
	
	public void setMes(int mes) 
	{
		Mes = mes;
	}
	
	public int getAno() 
	{
		return Ano;
	}
	
	public void setAno(int ano) 
	{
		Ano = ano;
	}
	
	public int getHorasTrabalhadas() 
	{
		return HorasTrabalhadas;
	}
	
	public void setHorasTrabalhadas(int horasTrabalhadas) 
	{
		HorasTrabalhadas = horasTrabalhadas;
	}
	
	public float getValorHora() 
	{
		return ValorHora;
	}
	
	public void setValorHora(float valorHora) 
	{
		ValorHora = valorHora;
	}  
}
