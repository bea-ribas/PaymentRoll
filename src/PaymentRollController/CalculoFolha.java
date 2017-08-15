package PaymentRollController;

public class CalculoFolha 
{
	private float salarioLiquido = 0, salarioBruto = 0, valorInss = 0, valorFgts = 0, impostoRenda = 0, aliquota = 0;

    public float CalculoFolhaPagamentoSalarioBruto (int horas, float valorHoras)
    {
        salarioBruto = 0;
        salarioBruto = horas * valorHoras;
        return salarioBruto;
    }

    public float CalculoFolhaPagamentoIR (int horas, float valorHoras)
    {
        salarioBruto = 0;
        impostoRenda = 0;
        aliquota = 0;

        salarioBruto = horas * valorHoras;

        if(salarioBruto <= 1903.98)
        {
            impostoRenda = 0;
            aliquota = 0;
        }
        
        if(salarioBruto >= 1903.99 && salarioBruto <= 2826.65)
        {
            aliquota = (float) ((salarioBruto * 7.5) / 100);
            impostoRenda = (float) (aliquota - 142.80);
        }
        
        if(salarioBruto >= 2826.66 && salarioBruto <= 3751.05)
        {
            aliquota = (salarioBruto * 15) / 100;
            impostoRenda = (float) (aliquota - 354.80);
        }
        
        if(salarioBruto >= 3751.06 && salarioBruto <= 4664.68)
        {
            aliquota = (float) ((salarioBruto * 22.5) / 100);
            impostoRenda = (float) (aliquota - 636.13);
        }
        
        if(salarioBruto >= 4664.69)
        {
            aliquota = (float) ((salarioBruto * 27.5) / 100);
            impostoRenda = (float) (aliquota - 869.36);
        }

        return impostoRenda;
    }

    public float CalculoFolhaPagamentoInss(int horas, float valorHoras)
    {
        salarioBruto = 0;
        valorInss = 0;

        salarioBruto = horas * valorHoras;

        if(salarioBruto <= 1659.38)
        {
            valorInss = (salarioBruto * 8) / 100;
        }
        
        if(salarioBruto >= 1659.39 && salarioBruto <= 2765.66)
        {
            valorInss = (salarioBruto * 9) / 100;
        }
        
        if(salarioBruto >= 2765.67 && salarioBruto <= 5531.31)
        {
            valorInss = (salarioBruto * 11) / 100;
        }
        
        if(salarioBruto > 5531.31)
        {
            valorInss = (float) 608.44;
        }

        return valorInss;
    }

    public float CalculoFolhaPagamentoFgts(int horas, float valorHoras)
    {
        salarioBruto = 0;
        valorFgts = 0;

        salarioBruto = horas * valorHoras;

        valorFgts = (salarioBruto * 8) / 100;
        
        return valorFgts;
    }

    public float CalculoFolhaPagamentoSalarioLiquido (float salarioBruto, float valorInss, float impostoRenda)
    {
        salarioLiquido = 0;

        salarioLiquido = salarioBruto - impostoRenda - valorInss;

        return salarioLiquido;
    }
}
