using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Collections;

namespace NHibernate_Web
{
    public class IUsuarioRepositorio
    {
        void Add(Usuario product);
    
        void Update(Usuario product);
    
        void Remove(Usuario product);
    
        Usuario GetById(Guid id);
    
        Usuario GetByLogin(string login);
    
        void getAllUsuarios();
    
        ICollection[] GetByPerfil(string perfil);
    }
}

