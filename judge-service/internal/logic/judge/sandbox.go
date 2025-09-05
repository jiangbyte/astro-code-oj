package judge

import (
	"context"
	"github.com/zeromicro/go-zero/core/logx"
	"judge-service/internal/dto"
)

type Sandbox struct {
	ctx       context.Context
	logger    logx.Logger
	Workspace Workspace
}

// 创建沙盒，传入上下文，工作空间
func NewSandbox(ctx context.Context, workspace Workspace) *Sandbox {
	return &Sandbox{
		ctx:       ctx,
		logger:    logx.WithContext(ctx),
		Workspace: workspace,
	}
}

// 编译，返回编译结果
func (s *Sandbox) Compile() (*dto.JudgeResultDto, error) {
	s.logger.Info("开始编译")
	c := NewCompiler(s.ctx, *s)
	return c.Execute()
}

// 执行，返回执行结果
func (s *Sandbox) Run() (*dto.JudgeResultDto, error) {
	s.logger.Info("开始执行")
	r := NewExecutor(s.ctx, *s)
	return r.Execute()
}
