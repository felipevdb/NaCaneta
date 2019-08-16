using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using hr_system_core;

namespace hr_system_EES
{
    public partial class Main : Form
    {
        public Main()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            RecursosHumanos rh = new RecursosHumanos();
            string mensagem = "Número Invalido";

            Candidato candidato = new Candidato(numeroInscricaoText.Text.ToString());

            if (rh.validaInscricao(candidato.numeroInscricao) == true) {
                candidato.ordemChamada = rh.calculaOrdem(candidato.numeroInscricao);
                mensagem = "Ordem de Chamada: " + candidato.ordemChamada.ToString();
            }

            label2.Text = mensagem;
            label2.Visible = true;

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
