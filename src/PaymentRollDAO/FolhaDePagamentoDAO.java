package PaymentRollDAO;

import java.util.ArrayList;
import java.util.List;

import PaymentRollModel.FolhaDePagamento;
import PaymentRollModel.Funcionario;

public class FolhaDePagamentoDAO implements FolhaDePagamentoInterface
{
	public List<FolhaDePagamento> folhaPagamento = new ArrayList<FolhaDePagamento>();

	@Override
	public void SalvarFolhaPagamento(FolhaDePagamento folhasPagamentos) 
	{
		folhaPagamento.add(folhasPagamentos);

	}

	@Override
	public List<FolhaDePagamento> BuscarFolhaPagamentoFuncionarioCpf(Funcionario funcionario) 
	{
		
		List<FolhaDePagamento> folhaPagamentoAux = new ArrayList<FolhaDePagamento>();
        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Funcionario.numCpf.equals(funcionario.numCpf))
            {
                folhaPagamentoAux.add(folhaPagamentoCadastrada);
            }
        }
        return folhaPagamentoAux;
	}

	@Override
	public List<FolhaDePagamento> BuscarFolhaPagamentoFuncionarioMesAno(Funcionario funcionario,
			FolhaDePagamento folhasPagamentos) 
	{
		List<FolhaDePagamento> folhaPagamentoAux = new ArrayList<FolhaDePagamento>();
        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Funcionario.numCpf.equals(funcionario.numCpf))
            {
                if(folhaPagamentoCadastrada.Mes == folhasPagamentos.Mes)
                {
                    if(folhaPagamentoCadastrada.Ano== folhasPagamentos.Ano)
                    {
                        folhaPagamentoAux.add(folhaPagamentoCadastrada);
                    }
                }
            }
        }
        return folhaPagamentoAux;
	}

	@Override
	public List<FolhaDePagamento> ListarFolhaPagamentoMesAno(FolhaDePagamento folhasPagamentos) 
	{
		List<FolhaDePagamento> folhaPagamentoAux = new ArrayList<FolhaDePagamento>();
        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Mes == folhasPagamentos.Mes)
             {
                if (folhaPagamentoCadastrada.Ano ==folhasPagamentos.Ano)
                {
                    folhaPagamentoAux.add(folhaPagamentoCadastrada);
                }
            }
        }
        return folhaPagamentoAux;
	}

	@Override
	public FolhaDePagamento ValidarFolhaPagamentoMesAno(FolhaDePagamento folhasPagamentos) 
	{
		for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Mes == folhasPagamentos.Mes )
            {
                if (folhaPagamentoCadastrada.Ano == folhasPagamentos.Ano)
                {
                    return folhaPagamentoCadastrada;
                }
            }
        }
        return null;
	}

	@Override
	public boolean ValidacaoSimplesMes(int mes) 
	{
		if(mes >= 1 && mes <= 12 )
        {
            return true;
        }
        else
        {
            return false;
        }
	}

	@Override
	public boolean ValidacaoSimplesAno(int ano) 
	{
		if (ano > 2000)
        {
            return true;
        }
        else
        {
            return false;
        }
	}

	@Override
	public List<FolhaDePagamento> RetornarLista() 
	{
		return folhaPagamento;
	}

 /*   public static void SalvarFolhaPagamento(FolhaDePagamento folhasPagamentos)
    {
        
        folhaPagamento.add(folhasPagamentos);

    }


    public static List<FolhaDePagamento> BuscarFolhaPagamentoFuncionarioCpf(Funcionario funcionario)
    {
        List<FolhaDePagamento> folhaPagamentoAux = new ArrayList<FolhaDePagamento>();
        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Funcionario.numCpf.equals(funcionario.numCpf))
            {
                folhaPagamentoAux.add(folhaPagamentoCadastrada);
            }
        }
        return folhaPagamentoAux;
    }

    public static List<FolhaDePagamento> BuscarFolhaPagamentoFuncionarioMesAno (Funcionario funcionario, FolhaDePagamento folhasPagamentos)
    {
        List<FolhaDePagamento> folhaPagamentoAux = new ArrayList<FolhaDePagamento>();
        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Funcionario.numCpf.equals(funcionario.numCpf))
            {
                if(folhaPagamentoCadastrada.Mes == folhasPagamentos.Mes)
                {
                    if(folhaPagamentoCadastrada.Ano== folhasPagamentos.Ano)
                    {
                        folhaPagamentoAux.add(folhaPagamentoCadastrada);
                    }
                }
            }
        }
        return folhaPagamentoAux;
    }

    public static List<FolhaDePagamento> ListarFolhaPagamentoMesAno(FolhaDePagamento folhasPagamentos)
    {
        List<FolhaDePagamento> folhaPagamentoAux = new ArrayList<FolhaDePagamento>();
        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Mes == folhasPagamentos.Mes)
             {
                if (folhaPagamentoCadastrada.Ano ==folhasPagamentos.Ano)
                {
                    folhaPagamentoAux.add(folhaPagamentoCadastrada);
                }
            }
        }
        return folhaPagamentoAux;
    }

    public static FolhaDePagamento ValidarFolhaPagamentoMesAno (FolhaDePagamento folhasPagamentos)
    {
        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamento)
        {
            if (folhaPagamentoCadastrada.Mes == folhasPagamentos.Mes )
            {
                if (folhaPagamentoCadastrada.Ano == folhasPagamentos.Ano)
                {
                    return folhaPagamentoCadastrada;
                }
            }
        }
        return null;
    }

    public static boolean ValidacaoSimplesMes (int mes)
    {
        if(mes >= 1 && mes <= 12 )
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public static boolean ValidacaoSimplesAno(int ano)
    {
        if (ano > 2000)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

    
    public static List<FolhaDePagamento> RetornarLista()
    {
        return folhaPagamento;
    }*/
}