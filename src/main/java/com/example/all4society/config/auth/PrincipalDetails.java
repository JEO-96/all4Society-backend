package com.example.all4society.config.auth;

//import org.springframework.security.core.userdetails.UserDetails;

//public class PrincipalDetails implements UserDetails, OAuth2User{
//
//    private static final long serialVersionUID = 1L;
//    private Member member;
//    private Map<String, Object> attributes;
//
//    // 일반 시큐리티 로그인시 사용
//    public PrincipalDetails(Member member) {
//        this.member = member;
//    }
//
//    // OAuth2.0 로그인시 사용
//    public PrincipalDetails(Member member, Map<String, Object> attributes) {
//        this.member = member;
//        this.attributes = attributes;
//    }
//
//    public Member getUser() {
//        return member;
//    }
//
//    @Override
//    public String getPassword() {
//        return member.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return member.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
//        collet.add(()->{ return member.getRole().toString();});
//        return collet;
//    }
//
//    // 리소스 서버로 부터 받는 회원정보
//    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
//
//    // User의 PrimaryKey
//    @Override
//    public String getName() {
//        return member.getEmail() + "";
//    }
//
//}