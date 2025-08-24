# TapeRecord - Plataforma de Streaming Musical  

<div align="center">
  <img src="https://github.com/RennerFarias/TapeRecord/raw/main/icon.png" width="400"/>
</div>

## 📌 Descrição  
O **TapeRecord** é um sistema de streaming de música desenvolvido em Java, seguindo os princípios de **Programação Orientada a Objetos (POO)**. O projeto simula as funcionalidades básicas de uma plataforma de streaming, permitindo que usuários se cadastrem, criem playlists personalizadas e gerenciem suas mídias musicais.

## 🎯 Funcionalidades Principais  

### 👤 **Sistema de Usuários**
- ✅ Cadastro de usuários com nome e e-mail
- ✅ Sistema de login por e-mail
- ✅ Validação de e-mails duplicados
- ✅ Logout e troca de usuários

### 🎵 **Gerenciamento de Mídias**
- ✅ Suporte a múltiplos tipos: **Música**, **Podcast** e **Audiobook**
- ✅ Informações completas: título, artista, duração e gênero
- ✅ Catálogo geral de mídias disponíveis
- ✅ Busca por título no catálogo
- ✅ Adicionar/remover mídias do catálogo

### 📋 **Sistema de Playlists**
- ✅ Criação de playlists personalizadas
- ✅ Adição/remoção de mídias nas playlists
- ✅ Visualização completa das playlists
- ✅ Cálculo automático da duração total
- ✅ Gerenciamento completo (criar, listar, editar, excluir)

### 🎼 **Gêneros Musicais**
- ✅ Enumeração `Genero` com: METAL, ROCK, SERTANEJO, PAGODE
- ✅ Classificação de músicas por gênero
- ✅ Validação de gêneros no cadastro

## 📊 Estruturas de Dados Utilizadas

| Estrutura | Uso | Justificativa |
|-----------|-----|---------------|
| `ArrayList<Usuario>` | Lista de usuários cadastrados | Acesso sequencial, busca por e-mail |
| `ArrayList<Midia>` | Catálogo geral de mídias | Flexibilidade para adicionar/remover |
| `ArrayList<Playlist>` | Playlists do usuário | Ordem de criação preservada |
| `ArrayList<Midia>` | Mídias dentro da playlist | Ordem de adição mantida |
| `Enum Genero` | Gêneros musicais disponíveis | Valores fixos e controlados |

## 🚀 Como Executar

### **Pré-requisitos**
- Java 8 ou superior
- IDE Java (IntelliJ, Eclipse, VS Code)

### **Compilação e Execução**
```bash
# Clone o repositório
git clone https://github.com/RennerFarias/TapeRecord.git

# Navegue até o diretório
cd TapeRecord

# Compile todos os arquivos
javac *.java Classes/*.java Classes/projeto/*.java

# Execute o programa
java Main
```

## 🎮 Como Usar

1. **Primeiro Acesso**: Cadastre-se com nome e e-mail
2. **Login**: Entre com seu e-mail cadastrado
3. **Adicione Mídias**: Vá em "Mídias" → "Adicionar midia ao catalogo"
4. **Crie Playlists**: Vá em "Playlists" → "Criar playlist"
5. **Adicione à Playlist**: Selecione sua playlist e adicione mídias do catálogo
6. **Gerencie**: Visualize, edite e organize suas playlists

## 👥 Equipe de Desenvolvimento

- **Renner Farias**
- **Jose Artur*
- **Igor Lima*
- **Elian Barros*

## 🎧 Sua música, seu jeito!
---

> 💡 **Nota**: Este projeto foi desenvolvido como atividade acadêmica, demonstrando a aplicação prática dos conceitos de Programação Orientada a Objetos em Java.
