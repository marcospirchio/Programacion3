import java.util.*;

class Usuario {
    private String id;

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class RedSocial {
    private Map<Usuario, List<Usuario>> seguidores;

    public RedSocial() {
        seguidores = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(Usuario usuario) {
        if (!seguidores.containsKey(usuario)) {
            seguidores.put(usuario, new ArrayList<>());
        }
    }

    // Permitir que un usuario siga a otro
    public void seguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor) && seguidores.containsKey(seguido)) {
            List<Usuario> seguidos = seguidores.get(seguidor);
            if (!seguidos.contains(seguido)) {
                seguidos.add(seguido);
            }
        } else {
            System.out.println("Uno o ambos usuarios no existen en el sistema.");
        }
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor)) {
            List<Usuario> seguidos = seguidores.get(seguidor);
            if (seguido != null && seguidos.contains(seguido)) {
                seguidos.remove(seguido);
            }
        }
    }

    //lista de usuarios que sigue un usuario 
    public List<Usuario> listaDeSeguidos(Usuario usuario) {
        return seguidores.getOrDefault(usuario, new ArrayList<>());
    }

    //lista de usuarios que siguen a un usuario 
    public List<Usuario> listaDeSeguidores(Usuario usuario) {
        List<Usuario> seguidoresUsuarios = new ArrayList<>();
        for (Map.Entry<Usuario, List<Usuario>> entry : seguidores.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidoresUsuarios.add(entry.getKey());
            }
        }
        return seguidoresUsuarios;
    }

    public static void main(String[] args) {
        // Creamos usuarios
        Usuario marcos = new Usuario("Marcos");
        Usuario mica = new Usuario("Mica");
        Usuario juli = new Usuario("Juli");

        // Creamos red social
        RedSocial redSocial = new RedSocial();

        redSocial.agregarUsuario(marcos);
        redSocial.agregarUsuario(mica);
        redSocial.agregarUsuario(juli);

        // Marcos sigue a Mica y Juli
        redSocial.seguir(marcos, mica);
        redSocial.seguir(marcos, juli);

        // Mica sigue a Juli
        redSocial.seguir(mica, juli);

        // Imprimir la lista de usuarios que sigue Marcos
        System.out.println("Usuarios que sigue Marcos: " + redSocial.listaDeSeguidos(marcos));

        // Imprimir la lista de seguidores de Juli
        System.out.println("Usuarios que siguen a Juli: " + redSocial.listaDeSeguidores(juli));

        // Marcos deja de seguir a Mica
        redSocial.dejarDeSeguir(marcos, mica);

        // Imprimir la lista de usuarios que sigue Marcos después de dejar de seguir a Mica
        System.out.println("Usuarios que sigue Marcos después de dejar de seguir a Mica: " + redSocial.listaDeSeguidos(marcos));
    }
}
