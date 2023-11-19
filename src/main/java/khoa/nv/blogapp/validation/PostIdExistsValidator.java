package khoa.nv.blogapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import khoa.nv.blogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PostIdExistsValidator implements ConstraintValidator<PostIdExists, Long> {
    private final PostRepository postRepository;

    @Autowired
    public PostIdExistsValidator(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return postRepository.existsById(id);
    }
}
