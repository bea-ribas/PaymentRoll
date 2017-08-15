package PaymentRollDAO;


import java.util.ArrayList;
import java.util.List;

import PaymentRollModel.Funcionario;

public class FuncionarioDAO implements FuncionarioInterface
{
	public List<Funcionario> funcionarios =  new ArrayList<Funcionario>();

	@Override
	public boolean SalvarFuncionario(Funcionario funcionario) 
	{
		if (BuscarFuncionarioCpf(funcionario) != null)
        {
            return false;
        }
        funcionarios.add(funcionario);
        return true;
	}

	@Override
	public Funcionario BuscarFuncionarioCpf(Funcionario funcionario) 
	{
		for (Funcionario funcionarioCadastrado : funcionarios)
        {
            if (funcionarioCadastrado.numCpf.equals(funcionario.numCpf))
            {
                return funcionarioCadastrado;
            }
        }
        return null;
	}

	@Override
	public List<Funcionario> RetornarLista() 
	{
		return funcionarios;
	}

	


	/*private static List<Funcionario> funcionarios =  new ArrayList<Funcionario>();

	public static boolean SalvarFuncionario(Funcionario funcionario)
    {
        if (BuscarFuncionarioCpf(funcionario) != null)
        {
            return false;
        }
        funcionarios.add(funcionario);
        return true;
    }

    
    public static Funcionario BuscarFuncionarioCpf(Funcionario funcionario)
    {
        for (Funcionario funcionarioCadastrado : funcionarios)
        {
            if (funcionarioCadastrado.numCpf.equals(funcionario.numCpf))
            {
                return funcionarioCadastrado;
            }
        }
        return null;
    }

    public static List<Funcionario> RetornarLista()
    {
        return funcionarios;
    }*/
}
