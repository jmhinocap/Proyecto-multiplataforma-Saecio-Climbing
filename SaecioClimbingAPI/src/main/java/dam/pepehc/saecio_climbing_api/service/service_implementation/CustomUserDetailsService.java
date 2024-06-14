package dam.pepehc.saecio_climbing_api.service.service_implementation;

import dam.pepehc.saecio_climbing_api.entity.Usuario;
import dam.pepehc.saecio_climbing_api.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * El tipo Custom user details service.
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(final String usuarioOCorreo) throws UsernameNotFoundException {
        log.info("[CustomUserDetailsService]-[loadUserByUsername]-[usuarioOCorreo: {}]-[Start]", usuarioOCorreo);
        Usuario usuario = usuarioRepository.findByNombreUsuarioOrCorreoElectronico(usuarioOCorreo, usuarioOCorreo)
                .orElseThrow(RuntimeException::new);
        
        Set<GrantedAuthority> authorities = usuario
                .getRoles()
                .stream()
                .map((rol) -> new SimpleGrantedAuthority(rol.getNombre().nombreRol)).collect(Collectors.toSet());
        User userDetails = new User(usuario.getCorreoElectronico(), new BCryptPasswordEncoder()
                .encode(usuario.getContrasena()), authorities);
        log.info("[CustomUserDetailsService]-[loadUserByUsername]-[userDetails: {}]-[End]", userDetails);
        
        return userDetails;
    }
}
