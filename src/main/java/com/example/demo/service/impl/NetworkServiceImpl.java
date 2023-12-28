package com.example.demo.service.impl;

import com.example.demo.domain.po.Network;
import com.example.demo.mapper.NetworkMapper;
import com.example.demo.service.INetworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 销售网站表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Service
public class NetworkServiceImpl extends ServiceImpl<NetworkMapper, Network> implements INetworkService {

}
