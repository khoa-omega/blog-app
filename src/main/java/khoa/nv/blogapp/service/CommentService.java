package khoa.nv.blogapp.service;

import khoa.nv.blogapp.dto.CommentDto;
import khoa.nv.blogapp.form.CommentCreateForm;
import khoa.nv.blogapp.form.CommentFilterForm;
import khoa.nv.blogapp.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(Long postId, CommentCreateForm form);

    CommentDto update(Long id, CommentUpdateForm form);

    void deleteById(Long id);
}
