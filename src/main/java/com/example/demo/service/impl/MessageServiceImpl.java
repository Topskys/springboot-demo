package com.example.demo.service.impl;

import com.example.demo.domain.po.Message;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品评价表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
