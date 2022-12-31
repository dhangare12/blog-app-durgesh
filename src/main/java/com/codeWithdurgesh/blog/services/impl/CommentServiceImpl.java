package com.codeWithdurgesh.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithdurgesh.blog.entities.Comment;
import com.codeWithdurgesh.blog.entities.Post;
import com.codeWithdurgesh.blog.exeptions.ResourceNotFoundException;
import com.codeWithdurgesh.blog.payloads.CommentDto;
import com.codeWithdurgesh.blog.repository.CommentRepo;
import com.codeWithdurgesh.blog.repository.PostRepo;
import com.codeWithdurgesh.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "post id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		Comment savedcomment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedcomment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
//		
//		Comment com=this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "commentId", commentId));
//		this.commentRepo.delete(com);
//		
	}

}
