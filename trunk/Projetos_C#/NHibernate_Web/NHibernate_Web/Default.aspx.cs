using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace NHibernate_Web
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btn_Cadastrar(object sender, EventArgs e)
        {
            Usuario usuario = new Usuario();

            usuario._nome = txt_nome.Text;
            usuario._login = txt_login.Text;
            usuario._senha = txt_senha.Text;
            usuario._perfil = txt_perfil.Text;
            usuario._email = txt_email.Text;

            UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();
            usuarioRepo.Add(usuario);
            
        }
    }
}