# AiVUKAT Sınıf Diyagramı

```mermaid
classDiagram
    %% Main Application Components
    class App {
        +Router
        +Routes
        +AuthProvider
    }

    class User {
        +Long id
        +String fullName
        +String email
        +String password
        +String baro
        +String plan
        +Integer active
        +LocalDateTime registrationDate
    }

    %% Document Classes
    class Kanun {
        +Long id
        +String mevzuatNo
        +String mevAdi
        +String kabulTarih
        +String resmiGazeteTarihi
        +String resmiGazeteSayisi
        +String mukerrer
        +String mevzuatTertip
        +String mevzuatTur
        +String url
        +String htmlMetin
    }

    class CbKararname {
        +Long id
        +String mevzuatNo
        +String mevAdi
        +String kabulTarih
        +String resmiGazeteTarihi
        +String resmiGazeteSayisi
        +String mukerrer
        +String mevzuatTertip
        +String mevzuatTur
        +String url
        +String htmlMetin
    }

    class Yonetmelik {
        +Long id
        +String mevzuatNo
        +String mevAdi
        +String kabulTarih
        +String resmiGazeteTarihi
        +String resmiGazeteSayisi
        +String mukerrer
        +String mevzuatTertip
        +String mevzuatTur
        +String url
        +String htmlMetin
    }

    %% Forum Related Classes
    class ForumTopic {
        +Long id
        +String title
        +String content
        +String category
        +User author
        +LocalDateTime createdAt
        +int likes
        +int comments
        +int views
    }

    class Comment {
        +Long id
        +String content
        +User author
        +ForumTopic topic
        +LocalDateTime createdAt
        +int likes
    }

    %% Favorite Related Classes
    class Favorite {
        +Long id
        +User user
        +String documentType
        +Long documentId
        +LocalDateTime createdAt
    }

    class FavoriteTopic {
        +Long id
        +User user
        +ForumTopic topic
        +LocalDateTime createdAt
    }

    %% Activity Related Classes
    class Activity {
        +Long id
        +String title
        +String description
        +LocalDateTime date
        +String type
        +boolean completed
        +User user
    }

    %% Relationships
    User "1" -- "*" ForumTopic : creates
    User "1" -- "*" Comment : writes
    User "1" -- "*" Favorite : has
    User "1" -- "*" FavoriteTopic : has
    User "1" -- "*" Activity : has
    ForumTopic "1" -- "*" Comment : contains
    ForumTopic "1" -- "*" FavoriteTopic : has
    Comment "1" -- "*" CommentLike : has
    ForumTopic "1" -- "*" TopicLike : has

    %% Inheritance for Document Types
    Kanun --|> Document
    CbKararname --|> Document
    Yonetmelik --|> Document
    Genelge --|> Document
    Teblig --|> Document
    Tuzuk --|> Document
    KanunHukmundeKararname --|> Document
    CumhurbaskanligiKarari --|> Document
```

## Açıklama

Bu sınıf diyagramı AiVUKAT uygulamasının temel yapısal bileşenlerini ve aralarındaki ilişkileri göstermektedir:

1. **Temel Varlıklar**:
   - `User`: Sistemin kullanıcılarını temsil eden ana varlık
   - `App`: Yönlendirme ve kimlik doğrulama işlemlerini yöneten ana uygulama bileşeni

2. **Belge Türleri**:
   - Temel `Document` sınıfından türeyen çeşitli yasal belge türleri (`Kanun`, `CbKararname`, `Yonetmelik` vb.)
   - Her belge türü `mevzuatNo`, `mevAdi`, `kabulTarih` gibi ortak özelliklere sahiptir

3. **Forum Sistemi**:
   - `ForumTopic`: Tartışma konularını temsil eder
   - `Comment`: Konulara yapılan yorumları temsil eder
   - `TopicLike` ve `CommentLike`: Konu ve yorumlar için beğeni işlemlerini yönetir

4. **Favoriler Sistemi**:
   - `Favorite`: Yasal belgeleri kaydetmek için
   - `FavoriteTopic`: Forum konularını kaydetmek için

5. **Aktivite Sistemi**:
   - `Activity`: Sistemdeki kullanıcı aktivitelerini takip eder

6. **İlişkiler**:
   - User ile oluşturduğu içerikler arasında bire-çok ilişkiler
   - ForumTopic ile yorumları arasında bire-çok ilişkiler
   - Favoriler ve beğeniler için çoka-çok ilişkiler 
