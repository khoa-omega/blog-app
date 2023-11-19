package khoa.nv.blogapp.service;

import khoa.nv.blogapp.dto.PostDto;
import khoa.nv.blogapp.form.PostCreateForm;
import khoa.nv.blogapp.form.PostFilterForm;
import khoa.nv.blogapp.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<PostDto> findAll(PostFilterForm form, Pageable pageable);

    PostDto findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(Long id, PostUpdateForm form);

    void deleteById(Long id);
}
