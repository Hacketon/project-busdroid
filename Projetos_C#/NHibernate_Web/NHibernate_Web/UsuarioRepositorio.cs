using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NHibernate;
using NHibernate.Criterion;
using System.Collections;

namespace NHibernate_Web
{
    public class UsuarioRepositorio : IUsuarioRepositorio {
    
        public void Add(Usuario usuario)
        {
            using (ISession session = NHibernateHelper.OpenSession())
            {
                using (ITransaction transaction = session.BeginTransaction())
                {
                    session.Save(usuario);
                    transaction.Commit();
                }
            }
        }
        
        public Usuario GetById(System.Guid id)
        {
            using (ISession session = NHibernateHelper.OpenSession())
            {
                return session.Get<Usuario>(id);
            }
        }
        
        public Usuario GetByLogin(string login)
        {
            using (ISession session = NHibernateHelper.OpenSession())
            {
                Usuario product = session.CreateCriteria(typeof(Usuario)).Add(Restrictions.Eq("Login", login)).UniqueResult<Usuario>();
                return product;
            }
        }
        
        public void Remove(Usuario usuario)
        {
            using (ISession session = NHibernateHelper.OpenSession())
            {
                using (ITransaction transaction = session.BeginTransaction())
                {
                    session.Delete(usuario);
                    transaction.Commit();
                }
            }
        }
        
        public void Update(Usuario usuario)
        {
            using (ISession session = NHibernateHelper.OpenSession())
            {
                using (ITransaction transaction = session.BeginTransaction())
                {
                    session.Update(usuario);
                    transaction.Commit();
                }
            }
        }

        public object getAllUsuarios()
        {
            using (ISession session = NHibernateHelper.OpenSession())
            {
                IList usuarios = session.CreateCriteria(typeof(Usuario)).List();
                return usuarios;
            }
        }

        public ICollection<Usuario> GetByPerfil(string perfil)
        {
            using (ISession session = NHibernateHelper.OpenSession())
            {
                dynamic usuarios = session.CreateCriteria(typeof(Usuario)).Add(Restrictions.Eq("Perfil", perfil)).List<Usuario>();
                return usuarios;
            }
        }

    }
}

