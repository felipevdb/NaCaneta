namespace hr_system_EES
{
    partial class Main
    {
        /// <summary>
        /// Variável de designer necessária.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpar os recursos que estão sendo usados.
        /// </summary>
        /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código gerado pelo Windows Form Designer

        /// <summary>
        /// Método necessário para suporte ao Designer - não modifique 
        /// o conteúdo deste método com o editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.calcularButton = new System.Windows.Forms.Button();
            this.numeroInscricaoText = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // calcularButton
            // 
            this.calcularButton.Location = new System.Drawing.Point(86, 56);
            this.calcularButton.Name = "calcularButton";
            this.calcularButton.Size = new System.Drawing.Size(75, 23);
            this.calcularButton.TabIndex = 0;
            this.calcularButton.Text = "Calcular";
            this.calcularButton.UseVisualStyleBackColor = true;
            this.calcularButton.Click += new System.EventHandler(this.button1_Click);
            // 
            // numeroInscricaoText
            // 
            this.numeroInscricaoText.Location = new System.Drawing.Point(144, 20);
            this.numeroInscricaoText.Name = "numeroInscricaoText";
            this.numeroInscricaoText.Size = new System.Drawing.Size(100, 20);
            this.numeroInscricaoText.TabIndex = 1;
            // 
            // Label Numero Inscricao
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(24, 23);
            this.label1.Name = "labelNumeroInscricao";
            this.label1.Size = new System.Drawing.Size(105, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Número de Inscrição";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // Label Ordem de Chamada
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(73, 92);
            this.label2.Name = "labelOrdemDeChamada";
            this.label2.Size = new System.Drawing.Size(105, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Ordem de Chamada: ";
            this.label2.Visible = false;
            // 
            // Main
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(262, 124);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.numeroInscricaoText);
            this.Controls.Add(this.calcularButton);
            this.Name = "Main";
            this.Text = "HR-System-EES";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button calcularButton;
        private System.Windows.Forms.TextBox numeroInscricaoText;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
    }
}

