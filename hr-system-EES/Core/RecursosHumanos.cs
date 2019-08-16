using System;
using System.Linq;

namespace hr_system_core
{

    public class RecursosHumanos
    {
    	public int calculaOrdem(string inscricao)
    	{
            int ordem = 0;

            for (int i = 0; i < inscricao.Length; i++) {

                for (int j = 0; j < int.Parse(inscricao[i].ToString()); j++) {
                    if ((j % 2 != 0) && (inscricao.IndexOf(j.ToString()) > i)) { ordem = ordem + calculaFatorial(inscricao.Length - 1 - i); }
                }
            }
            return ordem +1;
    	}

        public Boolean validaInscricao(string inscricao)
        {
            if ((int.TryParse(inscricao, out int n) == true) && (inscricao.Length == 5) && 
                (checaPorNumeroPar(inscricao) == false) && (inscricao.ToCharArray().Distinct().ToArray().Length == 5) ) {
                return true;
            }

            else return false;

        }


        private Boolean checaPorNumeroPar(string inscricao)
        {
            Boolean par = false;


            for (int i = 0; i < inscricao.Length; i++) if(inscricao[i] % 2 == 0) par = true;


            return par;
        }

        private int calculaFatorial(int numero)
        {
            int fatorial = numero;

            for (int i = numero-1; i >= 1; i--) {
                fatorial = fatorial * i;
            }

            return fatorial;
        }

    }
}