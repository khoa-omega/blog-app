package khoa.nv.blogapp.specification;

import jakarta.persistence.criteria.Predicate;
import khoa.nv.blogapp.entity.Comment;
import khoa.nv.blogapp.entity.Comment_;
import khoa.nv.blogapp.entity.Post_;
import khoa.nv.blogapp.form.CommentFilterForm;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class CommentSpecification {
    public static Specification<Comment> buildSpec(CommentFilterForm form) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();

            var postId = form.getPostId();
            if (postId != null) {
                var predicate = builder.equal(root.get(Comment_.post).get(Post_.id), postId);
                predicates.add(predicate);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
