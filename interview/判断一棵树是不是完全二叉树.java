//利用辅助队列的办法
	bool IsCompleteBinaryTree2()
	{
		queue<Node *>q;
		q.push(_root);
		Node *cur=q.front();
		//按照层序遍历的办法入队列直到遇到第一个NULL停止
		while (cur)
		{
			q.push(cur->_left);
			q.push(cur->_right);
			q.pop();
			cur=q.front();
		}
		//如果队列中全为NULL则是完全二叉树，否则不是
		while(!q.empty())
		{
			if(q.front())
				return false;
			q.pop();
		}
		return true;
	}
