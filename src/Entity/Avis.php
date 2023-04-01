<?php

namespace App\Entity;

use App\Repository\AvisRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: AvisRepository::class)]
class Avis
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 60)]
    /**
   *  @Assert\NotBlank(message="Le champ tel est obligatoire")
   * )
   */
    private ?string $role = null;

    #[ORM\Column(length: 230)]
     /**
   *  @Assert\NotBlank(message="Le champ satisfaction est obligatoire")
   * )
   */
    private ?string $nv_satif = null;

    #[ORM\Column(length: 250)]
     /**
   *  @Assert\NotBlank(message="Le champ du commentaire est obligatoire")
   * )
   */
    private ?string $comment = null;

    #[ORM\OneToMany(mappedBy: 'utilisateur', targetEntity: Avis::class)]
    private Collection $avis;

    #[ORM\ManyToOne(inversedBy: 'avis')]
    #[ORM\JoinColumn(nullable: false)]
    private ?Utilisateur $user = null;

    public function __construct()
    {
        $this->avis = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getRole(): ?string
    {
        return $this->role;
    }

    public function setRole(string $role): self
    {
        $this->role = $role;

        return $this;
    }

    public function getNvSatif(): ?string
    {
        return $this->nv_satif;
    }

    public function setNvSatif(string $nv_satif): self
    {
        $this->nv_satif = $nv_satif;

        return $this;
    }

    public function getComment(): ?string
    {
        return $this->comment;
    }

    public function setComment(string $comment): self
    {
        $this->comment = $comment;

        return $this;
    }

    /**
     * @return Collection<int, Avis>
     */
    public function getAvis(): Collection
    {
        return $this->avis;
    }

    public function addAvi(Avis $avi): self
    {
        if (!$this->avis->contains($avi)) {
            $this->avis->add($avi);
            $avi->setUtilisateur($this);
        }

        return $this;
    }

    public function removeAvi(Avis $avi): self
    {
        if ($this->avis->removeElement($avi)) {
            // set the owning side to null (unless already changed)
            if ($avi->getUtilisateur() === $this) {
                $avi->setUtilisateur(null);
            }
        }

        return $this;
    }

    public function getUser(): ?utilisateur
    {
        return $this->user;
    }

    public function setUser(?utilisateur $user): self
    {
        $this->user = $user;

        return $this;
    }
}
