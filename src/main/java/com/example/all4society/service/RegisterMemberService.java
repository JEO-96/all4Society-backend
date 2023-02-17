package com.example.all4society.service;

//@Service
//public class RegisterMemberService {
//    private final PasswordEncoder passwordEncoder;
//    private final MemberRepository repository;
//
//    @Autowired
//    public RegisterMemberService(PasswordEncoder passwordEncoder, MemberRepository repository) {
//        this.passwordEncoder = passwordEncoder;
//        this.repository = repository;
//    }
//
//    public Long join(String userid, String pw) {
//        Member member = Member.createUser(userid, pw, passwordEncoder);
//        validateDuplicateMember(member);
//        repository.save(member);
//        return member.getId();
//    }
//}
