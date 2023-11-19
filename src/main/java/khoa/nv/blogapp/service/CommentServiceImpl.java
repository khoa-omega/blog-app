package khoa.nv.blogapp.service;

import khoa.nv.blogapp.dto.CommentDto;
import khoa.nv.blogapp.entity.Comment;
import khoa.nv.blogapp.form.CommentCreateForm;
import khoa.nv.blogapp.form.CommentFilterForm;
import khoa.nv.blogapp.form.CommentUpdateForm;
import khoa.nv.blogapp.repository.CommentRepository;
import khoa.nv.blogapp.repository.PostRepository;
import khoa.nv.blogapp.specification.CommentSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(
            PostRepository postRepository,
            CommentRepository commentRepository,
            ModelMapper modelMapper
    ) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable) {
        var spec = CommentSpecification.buildSpec(form);
        return commentRepository.findAll(spec, pageable)
                .map(comment -> modelMapper.map(comment, CommentDto.class).withSelfRel());
    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable)
                .map(comment -> modelMapper.map(comment, CommentDto.class).withSelfRel());
    }

    @Override
    public CommentDto findById(Long id) {
        return commentRepository.findById(id)
                .map(comment -> modelMapper.map(comment, CommentDto.class).withSelfRel())
                .orElse(null);
    }

    @Override
    public CommentDto create(Long postId, CommentCreateForm form) {
        var post = postRepository.findById(postId).orElse(null);
        var comment = modelMapper.map(form, Comment.class);
        comment.setPost(post);
        var savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public CommentDto update(Long id, CommentUpdateForm form) {
        var comment = commentRepository.findById(id).orElse(null);
        modelMapper.map(form, comment);
        var savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
