package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    //查询当前用户地会话列表,真对每个会话只返回一条最新的私信
    List<Message> selectConversations(int userId, int offset, int limit);

    //查询当前用户的会话数量
    int selectConversationCount(int UserID);

    //查询某个会话所包含的私信列表
    List<Message> selectLetters(String conversationId, int offset, int limit);

    //查询某个会话所包含的私信数量
    int selectLetterCount(String conversationId);

    //查询未读私信数量
    int selectLetterUnreadCount(int userId, String conversationId);

    //新增消息
    int insertMessage(Message message);

    //修改状态
    int updateStatus(List<Integer> ids, int status);
}
