using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NHibernate_Web
{
    public class Usuario
    {
        public virtual int _usuarioid  { get; set; }
        public virtual string _nome { get; set; }
        public virtual string _login { get; set; }
        public virtual string _senha { get; set; }
        public virtual string _perfil { get; set; }
        public virtual string _email { get; set; }
    }
}
