package routes

import (
	"database/sql"

	"farmer-service-go/cmd/server/handler/farmer"
	"farmer-service-go/cmd/server/middleware"
	"farmer-service-go/internal/repository"
	"farmer-service-go/internal/service"

	"github.com/gin-gonic/gin"
)

type Router interface {
	MapRoutes()
}

type router struct {
	eng *gin.Engine
	rg  *gin.RouterGroup
	db  *sql.DB
}

func NewRouter(eng *gin.Engine, db *sql.DB) Router {
	return &router{
		eng: eng,
		db:  db,
	}
}
func (r *router) MapRoutes() {
	r.setGroup()
	r.buildMenuRoutes()
}

func (r *router) setGroup() {
	r.rg = r.eng.Group("/api/v1")
}

func (r *router) buildMenuRoutes() {
	repo := repository.NewRepository(r.db)
	service := service.NewService(repo)
	handler := farmer.NewMenu(service)
	gr := r.rg.Group("/menu", middleware.LoggerMIddleware())
	gr.POST("", handler.Create())
	gr.GET("/:id", handler.GetById())
	gr.GET("", handler.GetAll())
}
